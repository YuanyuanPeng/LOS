/**
 * Created by Phyllis Peng on 5/23/2016.
 */
public class LoanHandler {

    private String LoanId;
    private MyUser Myuser;
    private String Status;
    private Double Amount;
    private String Term;
    private Double Salary;
    private boolean approve;
    private boolean decline;
    private boolean reffer;

    public LoanHandler(){

    }
    public LoanHandler(String loadId, MyUser myUser, String status, Double amount, String term, Double salary){
        LoanId=loadId;
        Myuser=myUser;
        Status=status;
        Amount=amount;
        Term=term;
        Salary=salary;
    }

    public String getLoanId() {
        return LoanId;
    }

    public void setLoanId(String loanId) {
        LoanId = loanId;
    }

    public MyUser getMyuser() {
        return Myuser;
    }

    public void setMyuser(MyUser myuser) {
        Myuser = myuser;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String term) {
        Term = term;
    }


}
