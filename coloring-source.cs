using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
namespace Coloring
{
    class Program
    {
        static void Main(string[] args)
        {
            int n, m;

            Console.WriteLine("Input n(node의 갯수):");
            n = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Input m(color의 갯수):");
            m = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Input W[" + n + "][" + n + "]:");
            int[,] W = new int[n + 1, n + 1];
            for (int i = 1; i <= n; i++)
                for (int k = 1; k <= n; k++)
                    W[i, k] = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("");
            Coloring coloring = new Coloring(n, m, W);
            coloring.Process(0);
            if (coloring.get_count() == 0)
                Console.Write(m + "개의 color로는 coloring이 불가능 합니다.");
            else
                Console.Write(coloring.get_count() + "개의 coloring 결과를 찾았습니다.");
            Console.ReadLine();
        }
    }
    class Coloring
    {
        private int[] vcolor;
        private int[,] W;
        private int n, m, count;
        public Coloring(int n, int m, int[,] W)
        {
            this.W = W;
            this.n = n;
            this.m = m;
            vcolor = new int[n + 1];
        }
        public int[] get_vcolor()
        {
            return vcolor;
        }
        public int get_count()
        {
            return count;
        }
        public void Process(int i)
        {
            int color;
            if (promising(i))
            {
                if (i == n)
                {
                    count++;
                    for (int k = 1; k <= n; k++)
                    {
                        Console.Write(k + "V = " + vcolor[k] + "  ");
                    }
                    Console.WriteLine();
                }
                else
                {
                    for (color = 1; color <= m; color++)
                    {
                        vcolor[i + 1] = color;
                        Process(i + 1);
                    }
                }
            }
        }
        private bool promising(int i)
        {
            int j = 1;
            bool flag = true;
            while (j < i && flag)
            {
                if (W[i, j] == 1 && vcolor[i] == vcolor[j])
                    flag = false;
                j++;
            }
            return flag;
        }
    }
}
