package nytimes.maam.com.nytimes.util.network;

public interface ApiHandlerListener<T> {
	public void onSuccess(T response);
	public void onFail(Exception ex);
}
