package firetickets2;
// Generated Sep 8, 2015 7:01:42 PM by Hibernate Tools 4.3.1



/**
 * PmaColumnInfo generated by hbm2java
 */
public class PmaColumnInfo  implements java.io.Serializable {


     private Integer id;
     private String dbName;
     private String tableName;
     private String columnName;
     private String comment;
     private String mimetype;
     private String transformation;
     private String transformationOptions;
     private String inputTransformation;
     private String inputTransformationOptions;

    public PmaColumnInfo() {
    }

    public PmaColumnInfo(String dbName, String tableName, String columnName, String comment, String mimetype, String transformation, String transformationOptions, String inputTransformation, String inputTransformationOptions) {
       this.dbName = dbName;
       this.tableName = tableName;
       this.columnName = columnName;
       this.comment = comment;
       this.mimetype = mimetype;
       this.transformation = transformation;
       this.transformationOptions = transformationOptions;
       this.inputTransformation = inputTransformation;
       this.inputTransformationOptions = inputTransformationOptions;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDbName() {
        return this.dbName;
    }
    
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
    public String getTableName() {
        return this.tableName;
    }
    
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public String getColumnName() {
        return this.columnName;
    }
    
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getMimetype() {
        return this.mimetype;
    }
    
    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }
    public String getTransformation() {
        return this.transformation;
    }
    
    public void setTransformation(String transformation) {
        this.transformation = transformation;
    }
    public String getTransformationOptions() {
        return this.transformationOptions;
    }
    
    public void setTransformationOptions(String transformationOptions) {
        this.transformationOptions = transformationOptions;
    }
    public String getInputTransformation() {
        return this.inputTransformation;
    }
    
    public void setInputTransformation(String inputTransformation) {
        this.inputTransformation = inputTransformation;
    }
    public String getInputTransformationOptions() {
        return this.inputTransformationOptions;
    }
    
    public void setInputTransformationOptions(String inputTransformationOptions) {
        this.inputTransformationOptions = inputTransformationOptions;
    }




}


