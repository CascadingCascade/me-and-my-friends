import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int bankType = sc.nextInt();
        double deposit = sc.nextDouble();
        int yearTerm = sc.nextInt();
        double yearLimit = sc.nextDouble();
        double interestRate = 0; // 定期利率
        double currentRate = 0;  // 活期利率

        double oneYearRate = 0;
       
        //set rate
        if (bankType == 1) { 
        	currentRate = 0.00001; // 活期日利率为0.001%
        	switch (yearTerm) {
               	case 1:
               		interestRate = 0.0175; // 1年期定期每年利率为1.75%
               		break;
               	case 2:
               		interestRate = 0.0225; // 2年期定期每年利率为2.25%
               		break;
               	case 3:
                case 5:
                    interestRate = 0.0275; // 3年期和5年期定期每年利率均为2.75%
                    break;
                default:
                    interestRate = -1;     // 其他情况无效
            }
        } 
        else if (bankType == 2) {   // 民营银行
        	currentRate = 0.000012;   // 活期日利率为0.0012%
        	switch (yearTerm) {
               	case 1:
               		interestRate = 0.0195;   // 1年期定期每年利率为1.95%
               		break;
               	case 2:
               		interestRate = 0.0241;   // 2年期定期每年利率为2.41%
               		break;
               	case 3:
               		interestRate = 0.0275;   //3 年期定期每年利率为2.75%
               		break;
               	case 5: 
               		interestRate=0.03;//5 年期定期每年利率为3% 
               		break;
                default: 
                    interestRate=-1;//其他情况无效 
            }
        	oneYearRate = 0.0195;
        }	
///////////////////////////////////////////////////////////////////////////////////////////       
        while(yearLimit>=yearTerm){ 
        	deposit *= (1 + interestRate*yearTerm);
            yearLimit -= yearTerm;//更新剩余存款时间
        }
///////////////////////////////////////////////////////////////////////////////////////////
        int days = 0;
        double interest = 0;
        if(bankType == 1) {
        	days = ((int) yearLimit)*365;
        	days += Math.round((yearLimit - (int)yearLimit) * 1000);
        	deposit *= (1 + currentRate*days);
        }
        else if(bankType == 2) {
        	//interest = deposit * oneYearRate * (int)yearLimit;2
        	deposit *= (1 + oneYearRate * (int)yearLimit);
        	interest += deposit * Math.round((yearLimit - (int)yearLimit) * 1000) * currentRate;
        	deposit += interest;
        }
        
        
    	  System.out.printf("%.1f",deposit);
		}
}
