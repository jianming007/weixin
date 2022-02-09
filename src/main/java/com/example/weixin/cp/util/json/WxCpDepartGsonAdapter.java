/*
 * KINGSTAR MEDIA SOLUTIONS Co.,LTD. Copyright c 2005-2013. All rights reserved.
 *
 * This source code is the property of KINGSTAR MEDIA SOLUTIONS LTD. It is intended
 * only for the use of KINGSTAR MEDIA application development. Reengineering, reproduction
 * arose from modification of the original source, or other redistribution of this source
 * is not permitted without written permission of the KINGSTAR MEDIA SOLUTIONS LTD.
 */
package com.example.weixin.cp.util.json;

import com.google.gson.*;
import com.example.weixin.common.util.json.GsonHelper;
import com.example.weixin.cp.bean.WxCpDepart;

import java.lang.reflect.Type;

/**
 * WxCpDepart的gson适配器.
 *
 * @author Daniel Qian
 */
public class WxCpDepartGsonAdapter implements JsonSerializer<WxCpDepart>, JsonDeserializer<WxCpDepart> {
  private static final String ID = "id";
  private static final String NAME = "name";
  private static final String EN_NAME = "name_en";
  private static final String PARENT_ID = "parentid";
  private static final String ORDER = "order";
  private static final String DEPARTMENT_LEADER = "department_leader";


  @Override
  public JsonElement serialize(WxCpDepart group, Type typeOfSrc, JsonSerializationContext context) {
    JsonObject json = new JsonObject();
    if (group.getId() != null) {
      json.addProperty(ID, group.getId());
    }
    if (group.getName() != null) {
      json.addProperty(NAME, group.getName());
    }
    if (group.getEnName() != null) {
      json.addProperty(EN_NAME, group.getEnName());
    }
    if (group.getParentId() != null) {
      json.addProperty(PARENT_ID, group.getParentId());
    }
    if (group.getDepartmentLeader() != null) {
      JsonArray jsonArray = new JsonArray();
      for (String departmentLeader : group.getDepartmentLeader()) {
        jsonArray.add(new JsonPrimitive(departmentLeader));
      }
      json.add(DEPARTMENT_LEADER, jsonArray);
    }

    return json;
  }

  @Override
  public WxCpDepart deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
    throws JsonParseException {
    WxCpDepart depart = new WxCpDepart();
    JsonObject departJson = json.getAsJsonObject();
    if (departJson.get(ID) != null && !departJson.get(ID).isJsonNull()) {
      depart.setId(GsonHelper.getAsLong(departJson.get(ID)));
    }
    if (departJson.get(NAME) != null && !departJson.get(NAME).isJsonNull()) {
      depart.setName(GsonHelper.getAsString(departJson.get(NAME)));
    }
    if (departJson.get(EN_NAME) != null && !departJson.get(EN_NAME).isJsonNull()) {
      depart.setEnName(GsonHelper.getAsString(departJson.get(EN_NAME)));
    }
    if (departJson.get(ORDER) != null && !departJson.get(ORDER).isJsonNull()) {
      depart.setOrder(GsonHelper.getAsLong(departJson.get(ORDER)));
    }
    if (departJson.get(PARENT_ID) != null && !departJson.get(PARENT_ID).isJsonNull()) {
      depart.setParentId(GsonHelper.getAsLong(departJson.get(PARENT_ID)));
    }

    if (departJson.get(DEPARTMENT_LEADER) != null) {
      JsonArray positionJsonArray = departJson.get(DEPARTMENT_LEADER).getAsJsonArray();
      String[] departmentLeader = new String[positionJsonArray.size()];
      int i = 0;
      for (JsonElement jsonElement : positionJsonArray) {
        departmentLeader[i++] = jsonElement.getAsString();
      }
      depart.setDepartmentLeader(departmentLeader);
    }

    return depart;
  }

}
