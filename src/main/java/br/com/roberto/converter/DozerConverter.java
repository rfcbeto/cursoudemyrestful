package br.com.roberto.converter;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerConverter {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <O, D> D parseObject(O source, Class<D> destinationClass) {
		return mapper.map(source, destinationClass);
	} 
	
	public static <O, D> List<D> parseListObject(List<O> source, Class<D> destinationClass) {
		List<D> destination = new ArrayList<>();
		for (Object origem : source) {
			destination.add(mapper.map(origem, destinationClass));
		}
		return destination;
	}
}
