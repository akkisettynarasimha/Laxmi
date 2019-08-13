package com.strsar.laxmi.secarchbar;

import java.util.List;

public abstract class RepositoryEntityListCallback<T> {
    public abstract void onSuccess(List<T> entityList, boolean isCachedResponse);

    public abstract void onFailure(Exception e);
}
