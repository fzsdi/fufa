package ir.ifaeze.facts;

import java.util.Random;

public class FactBook {
    // Member variable (properties about the object)
    public String[] mFacts = {
            "Children grow faster in the spring!",
            "By the age of 60 most people lose half of their taste buds!",
            "On average, a person says 4,800 words in 24 hours!",
            "It is impossible to sneeze with your eyes open!",
            "Each of us has around 2,000 taste buds!",
            "The human eye can distinguish 10 million different colours!",
            "Your right lung can take in more air than your left!",
            "Parthenophobia is a fear of virgins!",
            "The total weight of the bacteria in the human body is 2 kg!",
            "Only 7% of people are left-handed!"
    };

    // Mathod (abilities: things the object can do)

    public String getFact() {
        // The button is clicked, so update the fact label with a new fact

        String fact;
        // Randomly select a fact

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mFacts.length);

        fact = mFacts[randomNumber];

        return fact;
    }
}
