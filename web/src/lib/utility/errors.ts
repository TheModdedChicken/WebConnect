class APIError extends Error {
  status: number;

  constructor(status: number, message: string = "An unknown error occurred while accessing the API") {
    super(message);

    this.status = status;
  }
}