package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.MemberCRUD;
import com.mycompany.librarymanagement.model.Member;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class AddmemberController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addmember_btn;

    @FXML
    private ImageView addresserror;

    @FXML
    private TextField addresstxt;

    @FXML
    private ImageView birthdayerror;

    @FXML
    private DatePicker birthdaytxt;

    @FXML
    private ImageView duedateerror;

    @FXML
    private DatePicker duedatetxt;

    @FXML
    private ImageView emailerror;

    @FXML
    private TextField emailtxt;

    @FXML
    private ImageView fullnameerror;

    @FXML
    private TextField fullnametxt;

    @FXML
    private ImageView phoneerror;

    @FXML
    private TextField phonetxt;

    @FXML
    void addmember(MouseEvent event) {
        member = new Member(
                0, 
                !fullnametxt.getText().isEmpty()&& !fullnametxt.getText().isBlank()?fullnametxt.getText():"",
                !addresstxt.getText().isEmpty()&&!addresstxt.getText().isBlank()?addresstxt.getText():"", 
                validatephone(phonetxt)?phonetxt.getText():"", 
                birthdaytxt.getValue()!=null?birthdaytxt.getValue().getYear() + "-" + birthdaytxt.getValue().getMonthValue() + "-" + birthdaytxt.getValue().getDayOfMonth():"", 
                validateemail(emailtxt)?emailtxt.getText():"",
                duedatetxt.getValue()!=null?duedatetxt.getValue().getYear() + "-" + duedatetxt.getValue().getMonthValue() + "-" + duedatetxt.getValue().getDayOfMonth():""
        );
        if(validateform(member)){
            List<Member> memberList = MemberCRUD.getListByEmail(member.getemail());
            boolean isHave = false;
            if(memberList.size()<=0){
                MemberCRUD.insert(member);
                resertform();
            } else{
                for (Member member1 : memberList) {
                    if(member1.getfull_name().equalsIgnoreCase(member.getfull_name())){
                        if(member1.getbirthday().equalsIgnoreCase(member.getbirthday())){
                            isHave = true;
                            resertform();
                            break;
                        }
                    }
                }
                if(!isHave){
                    MemberCRUD.insert(member);
                    resertform();
                }
            }
        }
    }

    @FXML
    void initialize() {
        
    }
    static Member member;

    boolean validatephone(TextField phone) {
        int n;
        try {
            n = Integer.parseInt(phone.getText());
        } catch (NumberFormatException e) {
            phoneerror.setVisible(true);
            return false;
        }
        String regex = "[0]{1}[1-9]{1}[0-9]{8,9}";
        boolean check = Pattern.compile(regex).matcher(!phone.getText().isEmpty()&&!phone.getText().isBlank()?phone.getText():"").matches();
        if(check==false){
            phoneerror.setVisible(true);
        } else {
            phoneerror.setVisible(false);
        }
        return check;
    }
    
    void resertform(){
        addresstxt.setText(null);
        fullnametxt.setText(null);
        emailtxt.setText(null);
        phonetxt.setText(null);
        birthdaytxt.setValue(null);
        duedatetxt.setValue(null);
        addresserror.setVisible(false);
        birthdayerror.setVisible(false);
        fullnameerror.setVisible(false);
        emailerror.setVisible(false);
        phoneerror.setVisible(false);
        duedateerror.setVisible(false);
    }

    boolean validateform(Member member){
        boolean check = true;
        if(member.getfull_name().equalsIgnoreCase("")||member.getfull_name()==null){
            fullnameerror.setVisible(true);
            check = false;
        } else {
            fullnameerror.setVisible(false);
        }
        if(member.getaddress().equalsIgnoreCase("")||member.getaddress()==null){
            addresserror.setVisible(true);
            check = false;
        } else{
            addresserror.setVisible(false);
        }
        if(member.getbirthday().equalsIgnoreCase("")||member.getbirthday()==null){
            birthdayerror.setVisible(true);
            check = false;
        } else{
            birthdayerror.setVisible(false);
        }
        if(member.getbirthday().equalsIgnoreCase("")||member.getbirthday()==null){
            duedateerror.setVisible(true);
            check = false;
        } else{
            duedateerror.setVisible(false);
        }
        if(member.getemail().equalsIgnoreCase("")||member.getemail()==null){
            emailerror.setVisible(true);
            check = false;
        } else{
            emailerror.setVisible(false);
        }
        if(member.getphone_number().equalsIgnoreCase("")||member.getphone_number()==null){
            phoneerror.setVisible(true);
            check = false;
        } else{
            phoneerror.setVisible(false);
        }
        return check;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private boolean validateemail(TextField txtemail) {
        String regex = "^([a-zA-Z0-9_]+)@([a-zA-Z0-9]+)(.[a-zA-Z]{2,6})+$";
        boolean check = Pattern.compile(regex).matcher(!txtemail.getText().isBlank()&&!txtemail.getText().isEmpty()?txtemail.getText():"").matches();
        if(check==false){
            emailerror.setVisible(true);
        } else {
            emailerror.setVisible(false);
        }
        return check;
    }
}
