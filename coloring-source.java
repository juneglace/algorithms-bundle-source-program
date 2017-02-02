import java.util.Scanner;

public class m_coloring {
 public static void main(String[] args) {
  int n, m;
  Scanner scan = new Scanner(System.in);
  System.out.println("Input n(node의 갯수):");
  n = scan.nextInt();
  System.out.println("Input m(color의 갯수):");
  m = scan.nextInt();
  System.out.println("Input W["+n+"]["+n+"]:");
  int[][] W = new int[n+1][n+1];
  for(int i = 1; i <= n; i++)
   for(int k = 1; k <= n; k++)
    W[i][k] = scan.nextInt();
  System.out.println("");
  Coloring coloring = new Coloring(n, m, W);
  coloring.Process(0);
  if(coloring.get_count() == 0)
   System.out.println(m + "개의 color로는 coloring이 불가능 합니다.");
  else
   System.out.println(coloring.get_count() + "개의 coloring 결과를 찾았습니다.");
 }
}
class Coloring {
 private int[] vcolor;
 private int[][] W;
 private int i;
 private int n, m, count;
 public Coloring(int n, int m, int[][] W) {
  this.W = W;
  this.n = n;
  this.m = m;
  vcolor = new int[n+1];
 }
 public int[] get_vcolor() {
  return vcolor;
 }
 public int get_count() {
  return count;
 }
 public void Process(int i) {
  int color;
  if(promising(i)){
   if(i == n){
    count++;
    for(int k = 1; k <= n; k++){
     System.out.print(k + "V = " +vcolor[k] + "  ");
    }
    System.out.println();
   }
   else{
    for(color = 1; color <= m; color++){
     vcolor[i+1] = color;
     Process(i+1);
    }
   }
  }
 }
 private boolean promising(int i) {
  int j = 1;
  boolean flag = true;
  while(j < i && flag){
   if(W[i][j] == 1 && vcolor[i] == vcolor[j])
    flag = false;
   j++;
  }
  return flag;
 }
}
