package Perceptron;

public class PerceptronMain {
	public static void main(String[] args) {
        Perceptron perceptron = new Perceptron();
        double inputs[][] = {{0,0},{0,1},{1,0},{1,1}};
        int outputs[] = {0,1,1,1};

        perceptron.Train(inputs, outputs,0.2, 0.1, 150);
        
         
        perceptron.CalculateOutput(new double[]{0.5,0.5});
        System.out.println(perceptron.getOutput());
        perceptron.CalculateOutput(new double[]{0.7,0.2});
        System.out.println(perceptron.getOutput());
        perceptron.CalculateOutput(new double[]{0.9,0.9});
        System.out.println(perceptron.getOutput());
        perceptron.CalculateOutput(new double[]{0,1});
        System.out.println(perceptron.getOutput());
        perceptron.CalculateOutput(new double[]{0.1, 0.1});
        System.out.println(perceptron.getOutput());

    }
}
