package com.webank.webase.node.mgr.deploy.mapper;

import org.apache.ibatis.jdbc.SQL;

import com.webank.webase.node.mgr.deploy.entity.TbChain;

public class TbChainSqlProvider {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_chain
     *
     * @mbg.generated
     */
    public static final String ALL_COLUMN_FIELDS = "id,chain_name,chain_desc,version,encrypt_type,chain_status,root_dir,create_time,modify_time";

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_chain
     *
     * @mbg.generated
     */
    public String insertSelective(TbChain record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("tb_chain");
        
        if (record.getChainName() != null) {
            sql.VALUES("chain_name", "#{chainName,jdbcType=VARCHAR}");
        }
        
        if (record.getChainDesc() != null) {
            sql.VALUES("chain_desc", "#{chainDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getVersion() != null) {
            sql.VALUES("version", "#{version,jdbcType=VARCHAR}");
        }
        
        if (record.getEncryptType() != null) {
            sql.VALUES("encrypt_type", "#{encryptType,jdbcType=TINYINT}");
        }
        
        if (record.getChainStatus() != null) {
            sql.VALUES("chain_status", "#{chainStatus,jdbcType=TINYINT}");
        }
        if (record.getRootDir() != null) {
            sql.VALUES("root_dir", "#{rootDir,jdbcType=VARCHAR}");
        }


        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            sql.VALUES("modify_time", "#{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_chain
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(TbChain record) {
        SQL sql = new SQL();
        sql.UPDATE("tb_chain");
        
        if (record.getChainName() != null) {
            sql.SET("chain_name = #{chainName,jdbcType=VARCHAR}");
        }
        
        if (record.getChainDesc() != null) {
            sql.SET("chain_desc = #{chainDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getVersion() != null) {
            sql.SET("version = #{version,jdbcType=VARCHAR}");
        }
        
        if (record.getEncryptType() != null) {
            sql.SET("encrypt_type = #{encryptType,jdbcType=TINYINT}");
        }
        
        if (record.getChainStatus() != null) {
            sql.SET("chain_status = #{chainStatus,jdbcType=TINYINT}");
        }
        if (record.getRootDir() != null) {
            sql.SET("root_dir = #{rootDir,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            sql.SET("modify_time = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}