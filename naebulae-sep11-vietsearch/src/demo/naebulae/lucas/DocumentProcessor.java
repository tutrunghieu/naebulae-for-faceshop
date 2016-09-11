package demo.naebulae.lucas;

public interface DocumentProcessor<T> {

	T invokeTransformer(T q);

}
