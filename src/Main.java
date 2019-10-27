
public class Main {


    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron(new double[]{-0.1,-0.6, -0.1});
        checkPredict(perceptron);
        for (int i = 0; i < 1_000 ; i++) {
            perceptron.learn(new double[]{0, 0, 0}, 0);
            perceptron.learn(new double[]{1, 0, 0}, 1);
            perceptron.learn(new double[]{0, 1, 0}, 0);
            perceptron.learn(new double[]{0, 0, 1}, 1);
            perceptron.learn(new double[]{1, 1, 0}, 0);
            perceptron.learn(new double[]{1, 0, 1}, 1);
            perceptron.learn(new double[]{0, 1, 1}, 0);
            perceptron.learn(new double[]{1, 1, 1}, 1);
        }
        System.out.println(perceptron);
        checkPredict(perceptron);
    }


    public static void checkPredict(Perceptron perceptron){
        System.out.println(perceptron.predict(new double[]{0, 0, 0}) == 0);
        System.out.println(perceptron.predict(new double[]{1, 0, 0}) == 1);
        System.out.println(perceptron.predict(new double[]{0, 1, 0}) == 0);
        System.out.println(perceptron.predict(new double[]{0, 0, 1}) == 1);
        System.out.println(perceptron.predict(new double[]{1, 1, 0}) == 0);
        System.out.println(perceptron.predict(new double[]{1, 0, 1}) == 1);
        System.out.println(perceptron.predict(new double[]{0, 1, 1}) == 0);
        System.out.println(perceptron.predict(new double[]{1, 1, 1}) == 1);
    }
}
