public class StackRealization {

    private Character[] stack;
    private Double[] stackDouble;
    private int tos;

    public StackRealization() {
        stack = new Character[50];
        stackDouble = new Double[50];
        tos = -1;
    }

    public void push(Character item){
        tos = tos + 1;
        stack[tos] = item;
    }

    public void pushDouble(Double item){
        tos = tos + 1;
        stackDouble[tos] = item;
    }

    public Character pop(){
        Character temp = stack[tos];
        tos = tos - 1;
        return temp;
    }
    public Double popDouble(){
        Double temp = stackDouble[tos];
        tos = tos - 1;
        return temp;
    }

    public Character peek(){
        return stack[tos];
    }

    public boolean empty(){
        if(tos > -1)
        return false;
        return true;
    }

}
