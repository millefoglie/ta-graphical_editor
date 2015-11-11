# Test Assignment : Graphical Editor

##Description

A very simple graphical editor which can add five predefined kinds of shapes to the drawing pane, make them rotate taking into account collisions detection, and also save and load documents. Undo/redo functionality is provided, as well. However, some things need refactoring, while others, like shapes dragging, currently remain unimplemented.

## Details

The application core consits of the GUI classess based on various Swing components, actions and listeners, the Document and the Editor classes. The former takes responsibility for representing edited documents, having DocumentContent (present shapes and their transformations) and the undo/redo caches, which are basically stacks of DocumentContents before any user input is made (adding shapes, deletion and so on). The editor itself just takes care of selecting brushes and switching documents.

All the shapes extend the AbstractShape class, which is an adapter to the Java 2D API shapes. It enables adding additional functionality to shapes, like rotations, polygonal proxies for intersection detections and so on. Each shape has its animation statuses containing enabled/disabled flags. Animations itself rely on Transformation objects and are handled by the AnimationThread. The latter traverses available transformations for the current document and applies them taking into account the frame-rate settings.

The operation of the editor also uses the Command pattern, which provides functionality for creating and removing shapes, saving and loading documents and so on. However, since undo and redo commands return the current document to the previous state, including applied transformations, it became impossible to add undo() method to the Command interface. Thus, a less efficient solution was used.

Finally, the ShapeComponent class allows for using 2D shapes as Swing components, i. e. adding them to the DrawingPane and adding MouseListeners to them or ContextMenues.