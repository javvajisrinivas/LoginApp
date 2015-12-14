package loginAction;

/**
 * Created by Srinivas Javvaji on 12/14/2015.
 */
public class CollectionDetails {


    private int company_id ;
    private String tag_no;
    private String line_code;
    private String party_code;
    private String party_name;
    private String party_id;
    private String party_mobile;
    private String village;
    private double amount;
    private int recp_no;
    private long doc_no;
    private int is_cancel = 0;
    private String agent_name;
    private String comments;

    // Date Format --> yyyy-MM-dd HH:mm:ss
    private String collection_date;
    private String inst_date;


    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getTag_no() {
        return tag_no;
    }

    public void setTag_no(String tag_no) {
        this.tag_no = tag_no;
    }

    public String getLine_code() {
        return line_code;
    }

    public void setLine_code(String line_code) {
        this.line_code = line_code;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getRecp_no() {
        return recp_no;
    }

    public void setRecp_no(int recp_no) {
        this.recp_no = recp_no;
    }

    public long getDoc_no() {
        return doc_no;
    }

    public void setDoc_no(long doc_no) {
        this.doc_no = doc_no;
    }

    public int getIs_cancel() {
        return is_cancel;
    }

    public void setIs_cancel(int is_cancel) {
        this.is_cancel = is_cancel;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getCollection_date() {
        return collection_date;
    }

    public void setCollection_date(String collection_date) {
        this.collection_date = collection_date;
    }

    public String getInst_date() {
        return inst_date;
    }

    public void setInst_date(String inst_date) {
        this.inst_date = inst_date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
