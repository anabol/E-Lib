public class Test {
    public static void main(String[] args) {
        Account account = new Account("15", "Stiop", "Max", "jhg", ",jk");
        XmlParser.pushAccount(account);
        XmlParser.xmlWrite("fdsdf.xml");
    }
}
