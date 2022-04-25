import java.util.Scanner;
class Telephone_Grid{
    static int factorial(int n) {
        if(n > 1)
          return n * factorial(n - 1);
        else
          return 1;
      }
    public static void main(String[] args) {
        int n,k,arr[][][]=new int[1][][],q;
        Scanner scan = new Scanner(System.in);
		q=scan.nextInt();
		for(int a=0;a<q;a++){
			n=scan.nextInt();
			
			if(1<=n && n<=10){
				k=n-2;                                          //  For swap
				arr[0]= new int[n][n];
				for(int i=0;i<n;i++){                           //Setting array
					for (int j = 0; j < n-i; j++)
						arr[0][i][j]=n-j-i;
					for (int j = n-i,l=0; j < n; j++,l++)
						arr[0][i][j]= n-l;
				}
				for (int loop = 0; loop < factorial(n-1); loop++)
				{
					System.out.print("[");                      //Displaying Possible Combinations for rows
					for (int i = 0; i < n; i++){
						System.out.print("[");
						for (int j = 0; j < n; j++)
							System.out.print(arr[0][i][j] + (j!=n-1? ",":"]"));
					}
					System.out.println("]");
					for(int i = 0; i < n; i++){                 //Swapping Colums of Array
						int temp = arr[0][i][k];
						arr[0][i][k] = arr[0][i][k +1];
						arr[0][i][k + 1] = temp;
					}
					k--;
					if(k==0)
						k=n-2;
					for(int i=0;i<=Math.ceil(n/2);i++){         //For arranging in descending order
						for(int j=i+1;j<n;j++){
							if(arr[0][i][0]<=arr[0][j][0]){
								for(int l=0;l<n;l++){
									int temp = arr[0][i][l];
									arr[0][i][l] = arr[0][j][l];
									arr[0][j][l] = temp;
								}
							}
						}
					}
				}
			}
		}
		scan.close();
    }
}