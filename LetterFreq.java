public class LetterFreq {
    char letter;
    int freq;

    public char getLetter() {
        return letter;
    }
    public void setLetter(char letter) {
        this.letter = letter;
    }
    public int getFreq() {
        return freq;
    }
    public void setFreq(int freq) {
        this.freq = freq;
    }

    public LetterFreq(char letter, int freq) {
        this.letter = letter;
        this.freq = freq;
    }
    @Override
    public String toString() {
        return "LetterFreq [letter=" + letter + ", freq=" + freq + "]";
    }

    

}
