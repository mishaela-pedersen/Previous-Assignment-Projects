import java.io.Serializable;
import java.text.DecimalFormat;

/*
 * Instantiable class for creating BMI objects
 */

public class BMI implements Serializable {
    //static variables
    private double[] rates = {29.9, 24.9, 18.5, 0};
    private String[] categories = {"Obese", "Overweight", "Normal", "Underweight"};
    //instance variables
    private int weight, height, option;
    private String fname, lname;

    //getters
    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getOption() {
        return option;
    }

    public String getFName() {
        return fname;
    }

    public String getLName() {
        return lname;
    }


    //setters
    public void setWeight(int w) {
        if(w > 0) {
            weight = w;
        }
        else {
            if(option == 1) {
                weight = 70;
            }
            else {
                weight = 154;
            }
        }
    }
    public void setHeight(int h) {
        if(h > 0) {
            height = h;
        }
        else {
            if(option == 1) {
                height = 170;
            }
            else {
                height = 66;
            }
        }
    }
    public void setOption(int o) {
        if(o > 0 && o <= 2) {
            option = o;
        }
        else {
            option = 1;
        }
    }

    public void setFName(String f) {
        if(!this.fname.isEmpty()) {
            this.fname = f;
        }
    }

    public void setLName(String l) {
        if(!this.lname.isEmpty()) {
            this.lname = l;
        }
    }

    //default constructor
    public BMI() {
        weight = 70;
        height = 170;
        option = 1;
        fname = "John";
        lname = "Doe";
    }

    //constructor overload
    public BMI(String f, String l, int w, int h, int o) {
        setFName(f);
        setLName(l);
        setWeight(w);
        setHeight(h);
        setOption(o);

    }

    //calculate bmi method - for metric, divide centimeters by 100 to get meters
    //Metric Formula: weight (kg) / [height (m)]2
    //Standard Formula: 703 x weight (lbs) / [height (in)]2
    public double calcBMI() {
        double bmiValue = 0;

        switch(option) {
            case 1:
                bmiValue = weight / ((height / 100.0) * (height / 100.0));
                break;
            case 2:
                bmiValue = 703 * (double) weight / (height * height);
                break;
        }

        return bmiValue;
    }



    @Override
    public String toString() {
        String cat = "";
        String op;
        Double bmiValue = calcBMI();
        DecimalFormat df = new DecimalFormat("##.##");

        if(option == 1){
            op = "Metric";
        }
        else{
            op = "Standard";
        }

        //search the rate chart to determine category
        for(int i = 0; i < rates.length; i++) {
            if(bmiValue > rates[i]) {
                cat = categories[i];
                break;
            }
        }

        return lname + "," + fname + weight +  height +  op +  df.format(bmiValue) +  cat + "\n";
    }
   /* public String toDisplay(){
        String op;
        String cat = "";
        Double bmiValue = calcBMI();
        DecimalFormat df = new DecimalFormat("##.##");
        if(option == 1){
            op = "Metric";
        }
        else{
            op = "Standard";
        }
        for(int i = 0; i < rates.length; i++) {
            if(bmiValue > rates[i]) {
                cat = categories[i];
                break;
            }
        }
        return fname + " " + lname + height + weight + op + cat;
    }
*/
}
