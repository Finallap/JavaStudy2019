import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {
    public static void main(String[] args) throws Exception {
        PipedReader in = new PipedReader();
        PipedWriter out = new PipedWriter();

        out.connect(in);
        Thread printThread = new Thread(new Print(in), "printThread");
        printThread.start();
        int recevie = 0;
        try {
            while ((recevie = System.in.read()) != -1) {
                out.write(recevie);
            }
        } finally {
            out.close();
        }
    }

    static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int recevie = 0;
            try {
                while ((recevie = in.read()) != -1) {
                    System.out.print((char) recevie);
                }
            } catch (IOException e) {

            }
        }
    }
}
