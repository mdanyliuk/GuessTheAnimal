package animals;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node {
    private String data;
    private Node no;
    private Node yes;
    private String negativeStatement;
    private String positiveStatement;

    public Node() {
    }

    public Node(String data, Node no, Node yes, String negativeStatement, String positiveStatement) {
        this.data = data;
        this.no = no;
        this.yes = yes;
        this.negativeStatement = negativeStatement;
        this.positiveStatement = positiveStatement;
    }

    public Node(String data, Node no, Node yes) {
        this.data = data;
        this.no = no;
        this.yes = yes;
    }

    public Node(String data) {
        this.data = data;
        this.no = null;
        this.yes = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNo() {
        return no;
    }

    public void setNo(Node no) {
        this.no = no;
    }

    public Node getYes() {
        return yes;
    }

    public void setYes(Node yes) {
        this.yes = yes;
    }

    public String getNegativeStatement() {
        return negativeStatement;
    }

    public void setNegativeStatement(String negativeStatement) {
        this.negativeStatement = negativeStatement;
    }

    public String getPositiveStatement() {
        return positiveStatement;
    }

    public void setPositiveStatement(String positiveStatement) {
        this.positiveStatement = positiveStatement;
    }

    @JsonIgnore
    public boolean isLeaf() {
        return (yes == null && no == null);
    }
}
