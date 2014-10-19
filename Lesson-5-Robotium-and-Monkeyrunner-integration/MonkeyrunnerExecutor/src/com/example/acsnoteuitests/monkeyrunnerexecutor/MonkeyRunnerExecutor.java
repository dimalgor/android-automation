package com.example.acsnoteuitests.monkeyrunnerexecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Class for catching LogCat and invoke MonkeyRunner scripts.
 */
public class MonkeyRunnerExecutor {

    // script used for testing
    public String SCRIPT;
    public String SCRIPT_COMMAND = Configuration.MONKEYRUNNER_DIR
                    + System.getenv(Configuration.SCRIPT_DIR_ENV) + Configuration.DELIMINATOR
                    + "src" + Configuration.DELIMINATOR;
    // used in StreamWrapper, is duplicated in test TCI_04_Chat
    private String MONKEYRUNNER_TAG = "MonkeyrunnerInvocation";

    private static Runtime rt = Runtime.getRuntime();
    private static MonkeyRunnerExecutor rte = new MonkeyRunnerExecutor();
    private static StreamWrapper output;
    private Process proc;

    public StreamWrapper getStreamWrapper(InputStream is, String type) {
        return new StreamWrapper(is, type);
    }

    private class StreamWrapper extends Thread {
        InputStream is = null;

        StreamWrapper(InputStream is, String type) {
            this.is = is;
        }

        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);

                    // look for filtered text in stream
                    if (line.contains(MONKEYRUNNER_TAG)) {
                        if (line.contains("sendPhoto")) {
                            SCRIPT = "test_chat_take_photo.py";
                            executeMonkeyRunnerTest();
                        } else if (line.contains("goBack")) {
                            SCRIPT = "goBackCommand.py";
                            executeMonkeyRunnerTest();
                        }
                    }
                }
            } catch (IOException ioe) {
            }
        }
    }

    /**
     * redirect output of LogCat to console
     */
    public void cathAdbOutput() {
        System.out.println("----- cathAdbOutput() with " + MONKEYRUNNER_TAG + " tag");
        System.out.println("----- cathAdbOutput() SCRIPT_COMMAND: " + SCRIPT_COMMAND);
        System.out.println("----- cathAdbOutput() ENV: "
                        + System.getenv(Configuration.SCRIPT_DIR_ENV));

        try {
            System.out.println("----- start listening of robotium ...");

            // clear LogCat
            proc = rt.exec("adb logcat -c");

            // set filter and direct to console
            proc = rt.exec("adb logcat " + MONKEYRUNNER_TAG + ":D *:S");

            output = rte.getStreamWrapper(proc.getInputStream(), "OUTPUT");
            output.start();
            output.join(3000);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * runs script defined in SCRIPT_COMMAND
     */
    public void executeMonkeyRunnerTest() {
        System.out.println("----- executeMonkeyRunnerTest()");

        try {
            System.out.println("----- Execute:  " + SCRIPT_COMMAND + SCRIPT);
            proc = rt.exec(SCRIPT_COMMAND + SCRIPT);

            output = rte.getStreamWrapper(proc.getInputStream(), "OUTPUT");
            output.start();
            output.join(3000);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
