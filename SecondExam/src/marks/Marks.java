/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marks;

/**
 *
 * @author Fares Abu Ali
 */
public class Marks {
    
    private double first,second,finali,avgGrade;

    public Marks(double first, double second, double finali, double avgGrade) {
        this.first = first;
        this.second = second;
        this.finali = finali;
        this.avgGrade = avgGrade;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public double getFinali() {
        return finali;
    }

    public void setFinali(double finali) {
        this.finali = finali;
    }

    public double getAvgGrade() {
        return sum(first, second, finali)/3;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
    
    public double sum(double first,double second,double finali){
        return first+second+finali;
    }

    @Override
    public String toString() {
        return "Marks{" + "first=" + first + ", second=" + second + ", finali=" + finali + ", avgGrade=" + avgGrade + '}';
    }
    
    
}
