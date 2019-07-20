/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
import edu.princeton.cs.introcs.StdAudio;
import es.datastructur.synthesizer.GuitarString;

public class GuitarHeroLite {
    private static final double CONCERT_A = 440.0;
    private static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        GuitarString stringA = new GuitarString(CONCERT_A);
        GuitarString stringC = new GuitarString(CONCERT_C);

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (key == 'a') {
                    stringA.pluck();
                    for (int i = 0; i < 50000; i += 1) {
                        StdAudio.play(stringA.sample());
                        stringA.tic();
                    }
                } else if (key == 'c') {
                    stringC.pluck();
                    for (int i = 0; i < 50000; i += 1) {
                        StdAudio.play(stringC.sample());
                        stringC.tic();
                    }
                }
            }
            /* compute the superposition of samples */
//            double sample = stringA.sample() + stringC.sample();
//
//        /* play the sample on standard audio */
//            StdAudio.play(sample);
//
//        /* advance the simulation of each guitar string by one step */
//            stringA.tic();
//            stringC.tic();
//        }
        }
    }
}

