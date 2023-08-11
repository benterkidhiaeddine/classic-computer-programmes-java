package compression;

class Main {
    public static void main(String[] args) {
        CompressedGene compressedGene = new CompressedGene("ACGT");
        String compressedGeneString = compressedGene.decompress();
        System.out.println(compressedGeneString);
    }
}
