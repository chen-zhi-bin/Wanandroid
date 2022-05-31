package com.program.wanandroiddemo.model.domain;

import java.util.List;

public class SystemCateGoriesChild {

    private List<DataBeanTitle> mDataBeans;

    @Override
    public String toString() {
        return "SystemCateGoriesChild{" +
                "mDataBeans=" + mDataBeans +
                '}';
    }

    public List<DataBeanTitle> getDataBeans() {
        return mDataBeans;
    }

    public void setDataBeans(List<DataBeanTitle> dataBeans) {
        mDataBeans = dataBeans;
    }

    public static class DataBeanTitle{
        private Integer id;
        private String name;
        private List<DataBean> mDataBeans;

        public DataBeanTitle(Integer id, String name, List<DataBean> dataBeans) {
            this.id = id;
            this.name = name;
            mDataBeans = dataBeans;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<DataBean> getDataBeans() {
            return mDataBeans;
        }

        public void setDataBeans(List<DataBean> dataBeans) {
            mDataBeans = dataBeans;
        }

        @Override
        public String toString() {
            return "DataBeanTitle{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", mDataBeans=" + mDataBeans +
                    '}';
        }

        public static class DataBean{

            private Integer parentChapterId;
            private String nameChild;

            public DataBean(Integer parentChapterId, String nameChild) {
                this.parentChapterId = parentChapterId;
                this.nameChild = nameChild;
            }

            public Integer getParentChapterId() {
                return parentChapterId;
            }

            public void setParentChapterId(Integer parentChapterId) {
                this.parentChapterId = parentChapterId;
            }

            public String getNameChild() {
                return nameChild;
            }

            public void setNameChild(String nameChild) {
                this.nameChild = nameChild;
            }

            @Override
            public String toString() {
                return "DataBean{" +
                        "parentChapterId=" + parentChapterId +
                        ", nameChild='" + nameChild + '\'' +
                        '}';
            }
        }
    }
}
