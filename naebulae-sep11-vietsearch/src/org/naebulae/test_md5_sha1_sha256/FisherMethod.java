package org.naebulae.test_md5_sha1_sha256;

public interface FisherMethod<S, T> 
{
	T invokeMethod(S xk);
}
