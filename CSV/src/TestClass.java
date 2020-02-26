public class TestClass {
    public static void main(String[] args) {
        String reference = "Maksim,Maksim,Maksim Sasha,Sasha,Sasha";
        System.out.println(reference);

        StringBuilder sb = new StringBuilder("<table>\n<tr>\n<th> ");

        char[] referenceToArray = reference.toCharArray();

        for (int i = 0; i < referenceToArray.length; ++i) {
            if (referenceToArray[i] == ',') {
                //sb.deleteCharAt(i + 1);
                sb.append("</th> \n <th>");
            }

            if (referenceToArray[i] == ' ') {
                sb.append("</th>\n</tr>\n<tr>\n<th>");
            }
            sb.append(referenceToArray[i]);
        }

        sb.append("</th>\n</tr>\n</table>");
        System.out.println(sb);
    }
}
