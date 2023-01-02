public class Model {

    private Viewer viewer;
    private ReversePolishNotation reversePN;
    private String temp;
    private String value;
    private double number;

    public Model(Viewer viewer) {
        this.viewer = viewer;
        reversePN = new ReversePolishNotation();
        temp = "";
        value = "";
    }

    public void doAction(String command) {
        if (command.equals("One")) {
            temp = temp + "1";
            value = value + "1";

        } else if (command.equals("Two")) {
            temp = temp + "2";
            value = value + "2";

        } else if (command.equals("Three")) {
            temp = temp + "3";
            value = value + "3";

        } else if (command.equals("Four")) {
            temp = temp + "4";
            value = value + "4";

        } else if (command.equals("Five")) {
            temp = temp + "5";
            value = value + "5";

        } else if (command.equals("Six")) {
            temp = temp + "6";
            value = value + "6";

        } else if (command.equals("Seven")) {
            temp = temp + "7";
            value = value + "7";

        } else if (command.equals("Eight")) {
            temp = temp + "8";
            value = value + "8";

        } else if (command.equals("Nine")) {
            temp = temp + "9";
            value = value + "9";

        } else if (command.equals("Zero")) {
            temp = temp + "0";
            value = value + "0";

        } else if (command.equals("Plus")) {
            value = value + "+";
            temp = "";
           return;

        } else if (command.equals("Minus")) {
            value = value + "-";
            temp = "";
            return;

        } else if (command.equals("Divide")) {
            value = value + "/";
            temp = "";
            return;

        } else if (command.equals("Multiple")) {
            value = value + "*";
            temp = "";
            return;

        } else if (command.equals("Percent")) {
            number = Double.parseDouble(temp);
            temp = checkingToInteger(number / 100);

        } else if (command.equals("Sqrt")) {
            number = Double.parseDouble(temp);
            temp = checkingToInteger(Math.sqrt(number));

        } else if (command.equals("Sqr")) {
            number = Double.parseDouble(temp);
            temp = checkingToInteger(Math.pow(number, 2));

        } else if (command.equals("OneDivideToX")) {
            number = Double.parseDouble(temp);
            temp = checkingToInteger(1 / number);

        } else if (command.equals("Sign")) {
            number = Double.parseDouble(temp);
            temp = checkingToInteger(-1 * number);

        } else if (command.equals("Point")) {
            if (!temp.substring(temp.lastIndexOf(" ") + 1).contains(".")) {
                if (!temp.equals("") && !temp.endsWith(" ")) {
                    value = value + ".";
                    temp = temp + ".";
                }
            }

        } else if (command.equals("C")) {
            value = "";
            temp = "";

        } else if (command.equals("Delete")) {
            if (temp.length() > 0) {
                value = value.substring(0, temp.length() - 1);
                temp = temp.substring(0, temp.length() - 1);
            }

        } else if (command.equals("Equal")) {
           temp = checkingToInteger(reversePN.getResult(value));
        }

            viewer.update(temp);

        }

        private String checkingToInteger(double result) {
            String answer = result % 1 == 0 ? "" + (int) result : "" + result;
            return answer;
        }
}

