package compression;

import java.util.BitSet;

public class CompressedGene {
    private BitSet bitSet;
    private int length;

    // Constructor

    CompressedGene(String geneString) {

        compress(geneString);
    }

    // Define a method that converts the gene String individual chars into a bit set
    private void compress(String geneString) {
        bitSet = new BitSet(length * 2);
        length = geneString.length();

        String upperGene = geneString.toUpperCase();

        for (int i = 0; i < length; i++) {
            // define the two locations of the two bits that are going to represent the
            // nucleotide
            int firstLocation = 2 * i;
            int secondLocation = 2 * i + 1;

            switch (upperGene.charAt(i)) {
                // A => 00
                case 'A':
                    bitSet.set(firstLocation, false);
                    bitSet.set(secondLocation, false);
                    break;
                // C => 01
                case 'C':
                    bitSet.set(firstLocation, false);
                    bitSet.set(secondLocation, true);
                    break;
                // T => 10
                case 'T':
                    bitSet.set(firstLocation, true);
                    bitSet.set(secondLocation, false);
                    break;
                // G => 11
                case 'G':
                    bitSet.set(firstLocation, true);
                    bitSet.set(secondLocation, true);
                    break;
                default:
                    throw new IllegalArgumentException(
                            "The gene sequence contains letters other then the base nucleotides ACTG", null);
            }
        }
    }

    // Define the decompress method
    public String decompress() {
        // If the bit set is empty
        if (bitSet == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length * 2; i += 2) {
            int firstBit = bitSet.get(i) ? 1 : 0;
            int secondBit = bitSet.get(i + 1) ? 1 : 0;

            // left shifting will put the first bit in it's rightful place while leaving a
            // vacant 0
            // The bitwise binary operator '|' always result in whatever digit the second
            // number is in when the first number is 0
            int twoBitsRepresentation = firstBit << 1 | secondBit;

            switch (twoBitsRepresentation) {
                case 0b00:
                    sb.append("A");
                    break;
                case 0b01:
                    sb.append("C");
                    break;
                case 0b10:
                    sb.append("T");
                    break;
                case 0b11:
                    sb.append("G");
                    break;

            }
        }

        return sb.toString();
    }
}
