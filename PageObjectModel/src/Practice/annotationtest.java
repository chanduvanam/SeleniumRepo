package Practice;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.testng.annotations.Test;

public class annotationtest {

	
	@sampleannotation(name="Srinivas")
	public String strValue;
	
	@Test
	public void testmethod()
	{
		 processAnnotations(this);
		System.out.println("strvalue is "+strValue);
	}
	public  void processAnnotations(Object obj)
	{
		try {
			Class cl = obj.getClass();
			for(Field f : cl.getDeclaredFields()) {
				// Since we are Validating fields, there may be many
				try {
					// Processing all the annotations on a single field
					for(Annotation a : f.getAnnotations()) {
						// Checking for a NullValueValidate annotation
						if(a.annotationType() == sampleannotation.class) {
							sampleannotation nullVal = (sampleannotation) a;
							System.out.println("'Processing the field : '"+ nullVal.name());

							// Setting the field to be accessible from our class
							// is it is a private member of the class under processing
							// (which its most likely going to be)
							// The setAccessible method will not work if you have
							// Java SecurityManager configured and active.
							f.setAccessible(true);

							if(f.get(obj) == null) {


							} else
							{


						}

					}
					}
				} catch(Exception e) {

					System.out.println(e.getMessage());

					e.printStackTrace();
				}
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	}
