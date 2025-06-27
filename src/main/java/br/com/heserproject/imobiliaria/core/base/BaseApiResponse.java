package br.com.heserproject.imobiliaria.core.base;


import lombok.Generated;

import java.io.Serializable;

public class BaseApiResponse<T> implements Serializable {
    private static final long serialVersionUID = 2183314685013899416L;
    private transient T content;

    public T getContent() {
        return this.content;
    }

    @Generated
    protected BaseApiResponse(BaseApiResponseBuilder<T, ?, ?> b) {
        this.content = b.content;
    }

    @Generated
    public static <T> BaseApiResponseBuilder<T, ?, ?> builder() {
        return new BaseApiResponseBuilderImpl();
    }

    @Generated
    public void setContent(T content) {
        this.content = content;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseApiResponse)) {
            return false;
        } else {
            BaseApiResponse<?> other = (BaseApiResponse) o;
            return other.canEqual(this);
        }
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof BaseApiResponse;
    }

    @Generated
    public int hashCode() {
        return 1;
    }

    @Generated
    public String toString() {
        return "BaseApiResponse(content=" + this.getContent() + ")";
    }

    @Generated
    public BaseApiResponse() {
    }

    @Generated
    public BaseApiResponse(T content) {
        this.content = content;
    }

    @Generated
    private static final class BaseApiResponseBuilderImpl<T> extends BaseApiResponseBuilder<T, BaseApiResponse<T>, BaseApiResponseBuilderImpl<T>> {
        @Generated
        private BaseApiResponseBuilderImpl() {
        }

        @Generated
        protected BaseApiResponseBuilderImpl<T> self() {
            return this;
        }

        @Generated
        public BaseApiResponse<T> build() {
            return new BaseApiResponse(this);
        }
    }

    @Generated
    public abstract static class BaseApiResponseBuilder<T, C extends BaseApiResponse<T>, B extends BaseApiResponseBuilder<T, C, B>> {
        @Generated
        private T content;

        public BaseApiResponseBuilder() {
        }

        @Generated
        protected abstract B self();

        @Generated
        public abstract C build();

        @Generated
        public B content(T content) {
            this.content = content;
            return this.self();
        }

        @Generated
        public String toString() {
            return "BaseApiResponse.BaseApiResponseBuilder(content=" + this.content + ")";
        }
    }
}

