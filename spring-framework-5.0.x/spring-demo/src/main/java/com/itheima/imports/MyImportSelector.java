package com.itheima.imports;

import com.itheima.annotations.QN;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import javax.annotation.PostConstruct;
import java.util.Map;

public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(QN.class.getName());
		boolean value = (boolean) annotationAttributes.get("value");
		if (value){
			System.out.println("1111");
			return new String[]{"com.itcast.CompanyDao"};
		}else {
			return new String[]{};
		}
	}
}
