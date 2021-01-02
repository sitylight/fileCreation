package com.rabbitchop.utils;

import com.rabbitchop.base.BaseService;
import com.rabbitchop.base.BaseServiceImpl;
import com.rabbitchop.base.CustomMapper;
import com.rabbitchop.repository.BaseRepository;
import com.rabbitchop.repository.impl.BaseRepositoryImpl;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;

/**
 * @author derrick
 */
public class JavaGenerator {
    private static final String REPOSITORY_PACKAGE = "com.rabbitchop.repository";
    private static final String REPOSITORY_IMPL_PACKAGE = "com.rabbitchop.repository.impl";
    private static final String MAPPER_PACKAGE = "com.rabbitchop.mapper";
    private static final String SERVICE_PACKAGE = "com.rabbitchop.service";
    private static final String SERVICE_IMPL_PACKAGE = "com.rabbitchop.service.impl";
    private static final String ENTITY_NAME = "com.rabbitchop.model.entity.MemberCampaign";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File fileDir = new File("src/main/java/");
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        Class<?> classz = Class.forName(ENTITY_NAME);
        createRepository(classz, REPOSITORY_PACKAGE, fileDir);
        createMapper(classz, MAPPER_PACKAGE, fileDir);
        createRepositoryImpl(classz, REPOSITORY_IMPL_PACKAGE, fileDir);
        createServiceInterface(classz, SERVICE_PACKAGE, fileDir);
        createServiceImpl(classz, SERVICE_IMPL_PACKAGE, fileDir);
    }

    private static void createRepository(Class<?> classz, String packageName, File folder) throws IOException {
        TypeSpec typeSpec = TypeSpec.interfaceBuilder(classz.getSimpleName() + "Repository")
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(ParameterizedTypeName.get(BaseRepository.class, classz))
                .addJavadoc("@author $S", "derrick")
                .build();

        JavaFile javaFile = JavaFile.builder(packageName, typeSpec).build();
        javaFile.writeTo(folder);
    }

    private static void createMapper(Class<?> classz, String packageName, File folder) throws IOException {
        TypeSpec typeSpec = TypeSpec.interfaceBuilder(classz.getSimpleName() + "Mapper").addModifiers(Modifier.PUBLIC)
                .addSuperinterface(ParameterizedTypeName.get(CustomMapper.class, classz))
                .addJavadoc("@author $S", "derrick")
                .build();

        JavaFile javaFile = JavaFile.builder(packageName, typeSpec).build();
        javaFile.writeTo(folder);
    }

    private static void createRepositoryImpl(Class<?> classz, String packageName, File folder)
            throws IOException, ClassNotFoundException {
        TypeSpec typeSpec = TypeSpec.classBuilder(classz.getSimpleName() + "RepositoryImpl")
                .addModifiers(Modifier.PUBLIC).superclass(ParameterizedTypeName.get(BaseRepositoryImpl.class, classz,
                        Class.forName(MAPPER_PACKAGE + "." + classz.getSimpleName() + "Mapper")))
                .addSuperinterface(Class.forName(REPOSITORY_PACKAGE + "." + classz.getSimpleName() + "Repository"))
                .addAnnotation(Repository.class)
                .addJavadoc("@author $S", "derrick")
                .build();

        JavaFile javaFile = JavaFile.builder(packageName, typeSpec).build();
        javaFile.writeTo(folder);
    }

    private static void createServiceInterface(Class<?> classz, String packageName, File folder) throws IOException {
        TypeSpec typeSpec = TypeSpec.interfaceBuilder(classz.getSimpleName() + "Service").addModifiers(Modifier.PUBLIC)
                .addSuperinterface(ParameterizedTypeName.get(BaseService.class, classz))
                .addJavadoc("@author $S", "derrick")
                .build();

        JavaFile javaFile = JavaFile.builder(packageName, typeSpec).build();
        javaFile.writeTo(folder);
    }

    private static void createServiceImpl(Class<?> classz, String packageName, File folder)
            throws IOException, ClassNotFoundException {
        TypeSpec typeSpec = TypeSpec.classBuilder(classz.getSimpleName() + "ServiceImpl")
                .addModifiers(Modifier.PUBLIC)
                .superclass(ParameterizedTypeName
                        .get(BaseServiceImpl.class, classz,
                                Class.forName(REPOSITORY_PACKAGE + "." + classz.getSimpleName() + "Repository")))
                .addSuperinterface(Class.forName(SERVICE_PACKAGE + "." + classz.getSimpleName() + "Service"))
                .addAnnotation(Service.class)
                .addJavadoc("@author $S", "derrick")
                .build();

        JavaFile javaFile = JavaFile.builder(packageName, typeSpec).build();
        javaFile.writeTo(folder);
    }
}
