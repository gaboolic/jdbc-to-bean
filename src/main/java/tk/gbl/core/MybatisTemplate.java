package tk.gbl.core;

import tk.gbl.util.TempUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Date: 2016/4/20
 * Time: 15:03
 *
 * @author gbl
 */
public class MybatisTemplate {
  private String tableName;
  private final Map<String, String> tableField;

  private String className;
  private String resultMap;
  private List<Property> propertyList;

  public MybatisTemplate(String tableName, Map<String, String> tableField) {
    this.tableName = tableName;
    this.tableField = tableField;

    this.className = TempUtil.getClassName(tableName);
    this.resultMap = TempUtil.temp(this.className) + "Map";

    this.propertyList = new ArrayList<Property>();
    for (Map.Entry<String, String> entry : tableField.entrySet()) {
      Property property = new Property();
      String column = entry.getKey();
      if(column.startsWith("_")) {
        continue;
      }
      String fieldName = TempUtil.temp(column);
      property.setProperty(fieldName);
      property.setColumn(column);
      this.propertyList.add(property);
    }
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public Map<String, String> getTableField() {
    return tableField;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public String getResultMap() {
    return resultMap;
  }

  public void setResultMap(String resultMap) {
    this.resultMap = resultMap;
  }

  public List<Property> getPropertyList() {
    return propertyList;
  }

  public void setPropertyList(List<Property> propertyList) {
    this.propertyList = propertyList;
  }
}
