package action05;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;

/*
Р—Р°РґР°С‡Р°1: Р’С‹РІРµСЃС‚Рё РІСЃРµ РјРµС‚РѕРґС‹ РєР»Р°СЃСЃР° String

Р—Р°РґР°С‡Р°2(ReflectionTask1Example) РќР°РїРёСЃР°С‚СЊ РјРµС‚РѕРґ РїСЂРёРЅРёРјР°СЋС‰РёР№ Р»СЋР±РѕР№ РѕР±СЉРµРєС‚.
РњРµС‚РѕРґ РІРѕР·РІСЂР°С‰Р°РµС‚ РІСЃРµ РєР»Р°СЃСЃС‹ РІ РёРµСЂР°СЂС…РёСЋ РєРѕС‚РѕСЂС‹С… РІС…РѕРґРёС‚ РґР°РЅРЅС‹Р№ РѕР±СЉРµРєС‚. 

Р—Р°РґР°С‡Р°3:(ReflectionTask2Example) РќР°РїРёСЃР°С‚СЊ РјРµС‚РѕРґ, РїСЂРёРЅРёРјР°СЋС‰РёР№ Р»СЋР±РѕР№ РѕР±СЉРµРєС‚, РІС‹РІРѕРґСЏС‰РёР№ СЃРїРёСЃРѕРє 
РІСЃРµС… РёРЅС‚РµСЂС„РµР№СЃРѕРІ РїРѕ РёРµСЂР°СЂС…РёРё РЅР°СЃР»РµРґРѕРІР°РЅРёСЏ РєР»Р°СЃСЃРѕРІ.
*/

public class ReflectionApiTest {

	public static void main(String[] args) {
		System.out.println(getAllObjectMethods(new String()));
		System.out.println(getParents(new ArrayList<>()));
		System.out.println(getInterfaces(new ArrayList<>()));
	}
	
	
	// Task 1
	public static ArrayList<Method> getAllObjectMethods(Object o) {
		
		ArrayList<Method> list = new ArrayList<>(); 
		
		Method[] methods = o.getClass().getDeclaredMethods();
		
		for (int i = 0; i < methods.length; i++) {
			list.add(methods[i]);
		}
		
		return list;
		
	}
	
	//Task 2
	public static ArrayList<Class<?>> getParents(Object obj) {
		
		ArrayList<Class<?>> list = new ArrayList<>(); 
		
		list.add(obj.getClass());
		
		Class<?> cls = obj.getClass().getSuperclass();
		
		while (cls != null) {
			list.add(cls);
			cls = cls.getSuperclass();
		}
		
		return list;
		
	}
	
	// Task 3
	public static HashSet<Class<?>> getInterfaces(Object obj) {

		HashSet<Class<?>> resultSet = new HashSet<>(); 
		
		ArrayList<Class<?>> classes = getParents(obj);
		
		for (Class<?> cl : classes) {
			Class<?> inf[] = cl.getInterfaces();
			for (int i = 0; i < inf.length; i++) {
				resultSet.add(inf[i]);
			}
		}
		
		return resultSet;

	}
	
}

