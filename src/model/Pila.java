package model;

import java.lang.IndexOutOfBoundsException;
import java.lang.StackOverflowError;


public class Pila {
  int[] arreglo;
  int top;
  int size;

  public Pila(int n){
    this.arreglo = new int[n];
    this.top = 0;
    this.size = n;
  }

  public void Push(int x) throws IndexOutOfBoundsException{
    if(this.top < this.size){
      this.top++;
      arreglo[top-1]=x;
    }
    else{
      throw new StackOverflowError();
    }
  }

  public int Pop() throws IndexOutOfBoundsException{
    if(this.top>0){
      int a = arreglo[this.top-1];
      this.top--;
      return a;
    }
    else{
      throw new IndexOutOfBoundsException();
    }
  }

  public int[] getArreglo() {
    return arreglo;
  }

  public int getTop() {
    return top;
  }

  public int getSize() {
    return size;
  }

  public void setArreglo(int[] arreglo) {
    this.arreglo = arreglo;
  }

  public void setTop(int top) {
    this.top = top;
  }

  public void setSize(int size) {
    this.size = size;
  }
}