package com.panodata.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RiskElementPO implements Serializable {
    private String id;

    private String name;

    private String description;

    private String datatypeid;

    private String logicexpress;

    private static final long serialVersionUID = 1L;

    public RiskElementPO() {}
    public RiskElementPO(String id, String name, String description, String datatypeid, String logicexpress, List<RiskAtomPO> atoms) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.datatypeid = datatypeid;
        this.logicexpress = logicexpress;
        this.atoms = atoms;
    }
    @Override
    public String toString() {
        return "RiskElementPO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", datatypeid='" + datatypeid + '\'' +
                ", logicexpress='" + logicexpress + '\'' +
                ", atoms=" + atoms +
                '}';
    }

    /*    private String foreign_ruleId;  //外键属于哪个规则id
    public String getForeign_ruleId() {
        return foreign_ruleId;
    }
    public void setForeign_ruleId(String foreign_ruleId) {
        this.foreign_ruleId = foreign_ruleId == null ? null : foreign_ruleId;
    }*/

    //一个数元对应多个原子
    private List<RiskAtomPO> atoms;
    public List<RiskAtomPO> getAtoms() {
        return atoms;
    }
    public void setAtoms(List<RiskAtomPO> atoms) {
        this.atoms = atoms == null ? null : atoms;
    }

    //--------------------------------------------------------
/*    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if((obj == null) || (obj.getClass() != this.getClass()))
            return false;
        RiskElementPO test = (RiskElementPO)obj;

        boolean cheak=true;

        List<RiskAtomPO> test_atom_list = test.atoms;
        List<RiskAtomPO> this_atom_list = this.atoms;
        for(RiskAtomPO test_atom:test_atom_list){
            for(RiskAtomPO this_atom:this_atom_list){
                if( !(this_atom.getId().equals(test_atom.getId())) ){  //原子id不相等
                    cheak=false;
                    break;
                }else{   //再比较输入参数
                    RiskAtomInputParamsPO test_input= test_atom.getAtomInputParams();
                    RiskAtomInputParamsPO this_input= this_atom.getAtomInputParams();

                    //输入参数的唯一标识inputParamId对应的business记录
                    List<RiskAtomInputParamBindBusinessfieldidPO>  test_Businessfield_list=test_input.getInputParamBindBusinessfield();
                    List<RiskAtomInputParamBindBusinessfieldidPO>  this_Businessfield_list=this_input.getInputParamBindBusinessfield();

                     if(test_input.getInputParamId().equals(this_input.getInputParamId())){ //唯一标识inputParamId相等的情况下
                         for(RiskAtomInputParamBindBusinessfieldidPO test_Businessfield:test_Businessfield_list){
                             for(RiskAtomInputParamBindBusinessfieldidPO this_Businessfield:this_Businessfield_list){
                                 if( !(this_Businessfield.getBusinessfieldid().equals(test_Businessfield.getBusinessfieldid())) && !(this_Businessfield.getRuleId().equals(test_Businessfield.getRuleId())) ){
                                     cheak=false;
                                     break;
                                 }
                             }
                         }
                     }

                }
            }
        }
        return id.equals(test.id)  //比较数元id
                && cheak;
    }

    public int hashCode()
    {
        int hash1 = 7;
        int hash2 = 31 * hash1 + id.hashCode();
        int hash3 = 31 * hash2 + (null == foreign_ruleId ? 0 : foreign_ruleId.hashCode());
        return hash3;
    }*/
    //--------------------------------------------------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? "" : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? "" : description.trim();
    }

    public String getDatatypeid() {
        return datatypeid;
    }

    public void setDatatypeid(String datatypeid) {
        this.datatypeid = datatypeid == null ? "" : datatypeid.trim();
    }

    public String getLogicexpress() {
        return logicexpress;
    }

    public void setLogicexpress(String logicexpress) {
        this.logicexpress = logicexpress == null ? "" : logicexpress.trim();
    }

 /*   public void main (String[] args){

        RiskElementPO  e1 = new RiskElementPO();
        e1.setId("01");
        e1.setName("test1");
        //
        List<RiskAtomPO> atom_list1=new ArrayList<RiskAtomPO>();
        RiskAtomPO ato1 = new RiskAtomPO();
        ato1.setId("ato1");

        List<RiskAtomInputParamsPO> input_list1= new ArrayList<RiskAtomInputParamsPO>();
        RiskAtomInputParamsPO input1=new RiskAtomInputParamsPO();
        input1.setBusinessfieldid("input1");
        input_list1.add(input1);

        ato1.setAtomInputParams(input_list1);
        atom_list1.add(ato1);
        //

        e1.setAtoms(atom_list1);

        //--------------------------------------
        RiskElementPO  e2 = new RiskElementPO();
        e2.setId("01");
        e2.setName("test1");

        List<RiskAtomPO> atom_list2=new ArrayList<RiskAtomPO>();
        RiskAtomPO ato2 = new RiskAtomPO();
        ato2.setId("ato1");

        List<RiskAtomInputParamsPO> input_list2= new ArrayList<RiskAtomInputParamsPO>();
        RiskAtomInputParamsPO input2=new RiskAtomInputParamsPO();
        input2.setBusinessfieldid("input1");
        input_list2.add(input2);

        ato2.setAtomInputParams(input_list2);
        atom_list2.add(ato2);

        e2.setAtoms(atom_list2);
//--------------------------------------
        Set<RiskElementPO> rset = new HashSet<RiskElementPO>();
        rset.add(e1);
        rset.add(e2);
        System.out.print("++++++++++++++++++++"+rset.size());
    }*/

}