package com.greenwooddev.Loren.Ipsum;

import com.thedeanda.lorem.LoremIpsum;

import java.util.Random;

public class LoremIpsumGenerator {

    private LoremIpsum loremIpsum = new LoremIpsum();
    private int howMany;
    private String modeType;

    public LoremIpsumGenerator(int howMany, String modeType) {
        this.howMany = howMany;
        this.modeType = modeType;
    }

    public String generate() {

        if (this.modeType.equals("words")) {
            return getWords();
        } else if (this.modeType.equals("paragraphs")) {
            return getParagraphs();
        } else {
            return getSentenses();
        }
    }

    public String getWords() {
        String result = loremIpsum.getWords(this.howMany);
        return result;
    }

    public String getParagraphs() {
        String result = loremIpsum.getHtmlParagraphs(this.howMany, this.howMany);
        return result;
    }

    public String getSentenses() {
        StringBuilder sentences = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < this.howMany; i++) {
            sentences.append(loremIpsum.getWords(rand.nextInt((7) )+4));
            sentences.append(". ");
        }

        return sentences.toString();
    }
}

