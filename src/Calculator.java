class Calculator {

    Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int a;
    int b;
    int result;

    void add() {
        result = a + b;
    }

    void subtract() {
        result = a - b;
    }

    void multiply() {
        result = a * b;
    }

    void divide() {
        result = a / b;
    }
}
