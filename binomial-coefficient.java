import java.util.Scanner;

public class minmult {
 public static void main(String[] args) {
  int n;
  Scanner scan = new Scanner(System.in);
  System.out.println("Input n:");
  n = scan.nextInt();
  System.out.println("Input d["+n+"]:");
  int[] d = new int[n+1];
  for(int i = 0; i <= n; i++)
   d[i] = scan.nextInt();
  Minmult2 minmult2 = new Minmult2(n, d);
  minmult2.Process();
  System.out.println("\nM[1]["+n+"]:"+minmult2.getMin());
  
  System.out.println("\nM["+n+"]["+n+"]:");
  for(int i = 1; i <= n; i++){
   for(int k = 1; k <= n ;k++)
    System.out.print(minmult2.getM()[i][k]+"  ");
   System.out.println();
  }
  
  System.out.println("\nP["+n+"]["+n+"]:");
  for(int i = 1; i <= n; i++){
   for(int k = 1; k <= n ;k++)
    System.out.print(minmult2.getP()[i][k]+"  ");
   System.out.println();
  }
  
 }
}
class Minmult2 {
 private int[][] M;
 private int[][] P;
 private int[] d;
 private int i, j, k, diagonal;
 private int n;
 public Minmult2(int n, int[] d) {
  this.d = d;
  this.n = n;
 }
 public int[][] getM() {
  return M;
 }
 public int[][] getP() {
  return P;
 }
 
 public int getMin() {
  return M[1][n];
 }
 public void Process() {
  M = new int[n+1][n+1];
  P = new int[n+1][n+1];
  for(i = 1; i <= n; i++)
   M[i][i] = 0;
  for(diagonal = 1; diagonal <= n - 1; diagonal++){
   for(i = 1; i <= n - diagonal; i++){
    j = i +diagonal;
    minimum(i,j);
   }
  }
  
 }
 private void minimum(int i, int j) {
  int min = 0, min2;
  for(k = i; k <= j-1; k++){
   if(k == i){
    min = M[i][k] + M[k+1][j] + d[i-1] * d[k] * d[j];
    P[i][j] = k;
   }
   else{
    min2 = M[i][k] + M[k+1][j] + d[i-1] * d[k] * d[j];
    
    if(min > min2){
     min = min2;
     P[i][j] = k;
    }
   }
  }
  M[i][j] = min;
 }
}
