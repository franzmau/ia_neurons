package Perceptron;
import java.util.Random;

public class Perceptron {

    private double[] weights;
    private double threshold;
    private int output;
    private int error;
    private double delta;
    
    public Perceptron(){
    	this.weights = new double[]{};	
    	this.threshold = 0;
    }
    
    public Perceptron(double[] weights, double treshold){
    	this.weights = weights;
    	this.threshold = treshold;
    }
    
    public void Train(double[][] inputs_weights, int[] outputs, double threshold, double learning_rate, int epoch)
    {

        this.threshold = threshold;
        int n = inputs_weights[0].length;
        int p = outputs.length;
        weights = new double[n];
        Random r = new Random();
        int i = 0;
        int total_error = 0;
        
        //initialize weights with random values
        for(i = 0; i < n; i++) {
            weights[i] = r.nextDouble();
        }

        for(i = 0; i < epoch; i++) { 
            total_error = 0;
            for(int j = 0; j < p; j++) {
                CalculateOutput(inputs_weights[j]);
                this.error = outputs[j] - output;
                
                total_error += this.error;
               
                for(int k = 0; k<n; k++) {
                    this.delta = learning_rate * inputs_weights[j][k] * this.error;
                    weights[k] += this.delta;
                }
                
                
            }
            if(total_error == 0)
                break;
        }

    }

    public void CalculateOutput(double[] inputs)
    {
        double sum = 0.0;
        for(int i = 0; i < inputs.length; i++) {
            sum += weights[i] * inputs[i];
        }

        if(sum > threshold)
            this.output = 1;
        else
            this.output = 0;
    }
    
    public int getOutput(){
    	return this.output;
    }

}