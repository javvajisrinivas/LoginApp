package loginAction;

import java.util.Date;

/**
 * Created by Srinivas Javvaji on 12/14/2015.
 */
public class DueDetails {

    private int company_id ;
    private String company_name;
    private String tag_no;
    private String party_code;
    private String party_name;
    private String party_id;
    private String party_mobile;
    private String village;
    private String line_code;

    private double inst_amt ;
    private double pending_amt;
    private int pending_insts;
    private double paid_amt;
    private String vehicle_details;
    // Date Format --> yyyy-MM-dd HH:mm:ss
    private String closed_date;
    private String inst_date;

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getTag_no() {
        return tag_no;
    }

    public void setTag_no(String tag_no) {
        this.tag_no = tag_no;
    }

    public String getParty_code() {
        return party_code;
    }

    public void setParty_code(String party_code) {
        this.party_code = party_code;
    }

    public String getParty_name() {
        return party_name;
    }

    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }

    public String getParty_id() {
        return party_id;
    }

    public void setParty_id(String party_id) {
        this.party_id = party_id;
    }

    public String getParty_mobile() {
        return party_mobile;
    }

    public void setParty_mobile(String party_mobile) {
        this.party_mobile = party_mobile;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getLine_code() {
        return line_code;
    }

    public void setLine_code(String line_code) {
        this.line_code = line_code;
    }

    public double getInst_amt() {
        return inst_amt;
    }

    public void setInst_amt(double inst_amt) {
        this.inst_amt = inst_amt;
    }

    public double getPending_amt() {
        return pending_amt;
    }

    public void setPending_amt(double pending_amt) {
        this.pending_amt = pending_amt;
    }

    public int getPending_insts() {
        return pending_insts;
    }

    public void setPending_insts(int pending_insts) {
        this.pending_insts = pending_insts;
    }

    public double getPaid_amt() {
        return paid_amt;
    }

    public void setPaid_amt(double paid_amt) {
        this.paid_amt = paid_amt;
    }

    public String getVehicle_details() {
        return vehicle_details;
    }

    public void setVehicle_details(String vehicle_details) {
        this.vehicle_details = vehicle_details;
    }

    public String getClosed_date() {
        return closed_date;
    }

    public void setClosed_date(String closed_date) {
        this.closed_date = closed_date;
    }

    public String getInst_date() {
        return inst_date;
    }

    public void setInst_date(String inst_date) {
        this.inst_date = inst_date;
    }
}
