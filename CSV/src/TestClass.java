public class TestClass {
    public static void main(String[] args) {
        String reference = "Maksim,Maksim,Maksim\nSasha,Sasha,Sasha";
        System.out.println(reference);

        StringBuilder sb = new StringBuilder("<table>");

        char[] referenceToArray = reference.toCharArray();

        for (int i = 0; i < referenceToArray.length; ++i) {
            //if(referenceToArray[i] == ",") {
            //    sb.
            //}
            sb.append(referenceToArray[i]);
        }
        System.out.println(sb);
    }
}
