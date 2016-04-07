package com.xxx.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author yuan
 *
 * @date 2016年4月7日 下午7:23:57
 */

public class DTOPopulator {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List populate(ResultSet rs, Class cla) throws Exception{
		
		ResultSetMetaData metaData = rs.getMetaData();
		
		int colCount = metaData.getColumnCount();
		
		List ret = new ArrayList();
		
		Field[] fields = cla.getDeclaredFields();
		
		while(rs.next()){
			Object newInstance = cla.newInstance();
			
			for(int i=1; i<=colCount; i++){
				try{
					Object value = rs.getObject(i);
					for(int j=0; j<fields.length; j++){
						Field f = fields[j];
						if(f.getName().equalsIgnoreCase(metaData.getColumnName(i).replaceAll("_",""))){
							BeanUtils.copyProperty(newInstance,f.getName(),value);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			ret.add(newInstance);
		}
		return ret;
	}
}

