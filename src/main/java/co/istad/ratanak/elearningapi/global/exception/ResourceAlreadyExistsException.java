package co.istad.ratanak.elearningapi.global.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String resource, String value) {
        super(resource + " with name '" + value + "' already exists");
    }
}