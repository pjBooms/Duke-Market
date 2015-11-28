package dukemarket.http;

import org.restler.client.Call;
import org.restler.client.CallEnhancer;
import org.restler.client.CallExecutor;
import org.restler.http.HttpExecutionException;

public class ErrorMapper implements CallEnhancer {
    @Override
    public Object apply(Call call, CallExecutor callExecutor) {
        try {
            return callExecutor.execute(call);
        } catch (HttpExecutionException e) {
            if (e.getStatus().code == 404) {
                throw new NotFoundException(e.getMessage(), e.getCause(), e.getStatus());
            } else {
                throw e;
            }
        }
    }
}
