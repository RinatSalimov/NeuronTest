public class Perceptron {
    private double[] weights;
    private double learningRate = 0.1;

    public Perceptron(double[] weights) {
        this.weights = weights;
    }

    private double sigmoid(double x){
        return 1.0/(1+Math.pow(Math.E, -1*x));
    }

//    private double sigmoidDerivative(double x){
//        return sigmoid(x)*(1 - sigmoid(x));
//    }

    private double sumOfImpulsWithWeights(double[] impuls){
        double result = 0;
        if(weights.length == impuls.length){
            for (int i = 0; i < weights.length; i++) {
                result += weights[i]*impuls[i];
            }
        }
        return result;
    }

    public double predict(double[] impuls){
        double result = sigmoid(sumOfImpulsWithWeights(impuls));
        if(result > 0.5) {
            return 1;
        } else {
            return 0;
        }
    }

    public void learn(double[] impuls, double answer){
        double impulsWithWeights = sumOfImpulsWithWeights(impuls);
        double sigmoid = sigmoid(impulsWithWeights);
        double error =  sigmoid - answer;

        double weightsDelta = error*sigmoid*(1-sigmoid);
        for (int i = 0; i < weights.length; i++) {
            weights[i] = weights[i] - impuls[i]*weightsDelta*learningRate;
        }

    }

    @Override
    public String toString(){
        String result = "";
        for (int i = 0; i < weights.length; i++) {
            result += "Вес " + i + ": " + weights[i] + "\n";
        }
        result += "\n";

        return result;
    }

}
