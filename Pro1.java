import java.util.Arrays;
import java.util.Scanner;

class Pro1{
	public static void main(String[] args) {

		Scanner scan= new Scanner(System.in);
		int x =scan.nextInt();
		int number [][]= new int[x][],index[]=new int[number.length],ans[]=new int[number.length];

		if(1<=number.length && number.length<=1000){        // Constrains of input
			
			Scanner scan1= new Scanner(System.in);
			for (int i=0;i<number.length ;i++){             //Taking Inputs in String format and Converting into array of numbers

				String str= scan1.nextLine();
				str= str.substring(1, (str.length() - 1));
				String temp []= str.split(",");
				number [i]= new int[temp.length];
				for (int j=0;j< temp.length;j++ )
					number[i][j]=Integer.parseInt(temp[j]);
			}

			System.out.print("[");
			for (int i=0;i<number.length;i++){         //Time calculation

				int sum=0;
				Arrays.sort(number[i]);
				for (int j=0;j<number[i].length;j++) {
					if(j+1==number[i].length || number[i][j]!=number[i][j+1])
						sum+=number[i][j];
				}
				index[i]=sum+i;     //Index used to find Index of Particular Time after Sorting
				ans[i]=sum;
			}

			Arrays.sort(index);     //Used to Show output in decreasing order wrt Time
			Arrays.sort(ans);

			for (int i=0; i<index.length;i++)
				System.out.print((index[i]-ans[i]+1)+","+ans[i]+(i!=index.length-1?',':']'));
		}
	}
}	